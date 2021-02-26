import cv2
import numpy as np
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt


def ComputeHist(img):
    h, w = img.shape
    hist, bin_edge = np.histogram(img.reshape(1, w * h), bins=list(range(257)))
    return hist


def ComputeMinLevel(hist, rate, pnum):
    sum = 0
    for i in range(256):
        sum += hist[i]
        if (sum >= (pnum * rate * 0.001)):
            return i


def ComputeMaxLevel(hist, rate, pnum):
    sum = 0
    for i in range(256):
        sum += hist[255 - i]
        if (sum >= (pnum * rate * 0.001)):
            return 255 - i


def LinearMap(minlevel, maxlevel):
    if (minlevel >= maxlevel):
        return []
    else:
        newmap = np.zeros(256)
        for i in range(256):
            if (i < minlevel):
                newmap[i] = 0
            elif (i > maxlevel):
                newmap[i] = 255
            else:
                newmap[i] = (i - minlevel) / (maxlevel - minlevel) * 255
        return newmap


def CreateNewImg(img):
    h, w, d = img.shape
    newimg = np.zeros([h, w, d])
    for i in range(d):
        imghist = ComputeHist(img[:, :, i])
        minlevel = ComputeMinLevel(imghist, 1, h * w)
        maxlevel = ComputeMaxLevel(imghist, 1, h * w)
        newmap = LinearMap(minlevel, maxlevel)
        if (newmap.size == 0):
            continue
        for j in range(h):
            newimg[j, :, i] = newmap[img[j, :, i]]
    return newimg


img = cv2.imread('C:/f1.jpg')  # åŽŸå›¾ç‰‡å


newimg = CreateNewImg(img)
cv2.imwrite('f11_hist.jpg', newimg)  # æ”¹å›¾ç‰‡å


img = cv2.imread('f11_hist.jpg')  # æ”¹å›¾ç‰‡å


ratio = img.shape[0] / img.shape[1]
img_resize = cv2.resize(img, (720, int(720 * ratio)),
                        interpolation=cv2.INTER_AREA)
Blur = cv2.GaussianBlur(img_resize, (3, 3), 0)
dst = cv2.pyrMeanShiftFiltering(Blur, 22, 37)
b, g, r = cv2.split(dst)
GRAY = cv2.cvtColor(dst, cv2.COLOR_BGR2GRAY)

Canny = cv2.Canny(r, 200, 1200, apertureSize=5)
