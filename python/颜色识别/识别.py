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


img = cv2.imread('f1.jpg')  # åŽŸå›¾ç‰‡å


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

kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (3, 3))
binary = cv2.morphologyEx(Canny, cv2.MORPH_OPEN, kernel)

contours, hierarchy = cv2.findContours(
    Canny, cv2.RETR_CCOMP, cv2.CHAIN_APPROX_SIMPLE)
contours_fix = []
for i in contours:
    rect = cv2.boundingRect(i)
    x = rect[0]
    y = rect[1]
    weight = rect[2]
    height = rect[3]
    if weight * height > 50:
        contours_fix.append(i)

cv2.drawContours(binary, contours_fix, -1, (255, 255, 255), 1)
cv2.imshow("binary", binary)
cv2.waitKey(0)

###
###


img_RGB = cv2.cvtColor(img_resize, cv2.COLOR_BGR2RGB)
img_Guassian = cv2.GaussianBlur(img_resize, (3, 3), 0)
kernel = np.array([[0, -1, 0], [-1, 5, -1], [0, -1, 0]], np.float32)
dst1 = cv2.filter2D(img_Guassian, -1, kernel=kernel)
dst2 = cv2.pyrMeanShiftFiltering(dst1, 20, 42)
img_rgb = cv2.cvtColor(dst2, cv2.COLOR_BGR2RGB)
(height, width, channels) = img_rgb.shape
img_data = img_rgb.reshape(height * width, channels)

kmeans = KMeans(n_clusters=10)   # ä¿®æ”¹é¢œè‰²ç§ç±»Kçš„æ•°ç›®


kmeans.fit(img_data)

color_label = {}
for i in range(len(kmeans.cluster_centers_)):
    color_label[i] = kmeans.cluster_centers_[i]
print('é¢œè‰²ä»¥åŠå…¶å¯¹åº”çš„æ ‡ç­¾ä¸ºï¼š {}'.format(color_label)))
    color_num={}
    for m in range(len(np.unique(kmeans.labels_))):
    print(np.sum(kmeans.labels_ == m))
    print(color_label[m])
    color_num[np.sum(kmeans.labels_ == m)]=color_label[m]
    print('è‰²å½©æŽ’åºå‰å­—å…¸æ˜ å°„ä¸ºï¼š {}'.format(color_num))))
    color_num_sorted=sorted(
                            color_num.items(), key=lambda x: x[0], reverse=True)
    print('è‰²å½©æŽ’åºåŽå­—å…¸æ˜ å°„ä¸ºï¼š {}'.format(color_num_sorted))))
    color_num_ratio=[]
    for i in range(len(color_num_sorted)):
    color_num_ratio.append(color_num_sorted[i][0])
    color_num_ratio=color_num_ratio / np.sum(color_num_ratio)
    print('è‰²å½©æ•°ç›®æ±‚å–æ¯”ä¾‹ä¹‹åŽï¼š {}'.format(color_num_ratio))))

    print('[INFO] æ˜¾ç¤ºè‰²å¡å›¾åƒ......')')
    color_card=np.zeros(shape=(height, width + 100, 3), dtype=np.int32)
    for i in range(height):
    for j in range(width):
        color_card[i][j]=img_RGB[i][j]
    start=0
    for i in range(len(kmeans.cluster_centers_)):
    color=color_num_sorted[i][1]
    row_start=int(color_num_ratio[i] * height)
    if i == len(kmeans.cluster_centers_) - 1:
        color_card[start:, width:width + 100]=color
    color_card[start: start + row_start, width:width + 100]=color
    start += row_start

    plt.imshow(color_card)
    plt.show()
