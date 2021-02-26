
import tkinter as tk
from tkinter import filedialog
import tkinter


def getLocalFile():
    root = tk.Tk()
    root.withdraw()

    filePath = filedialog.askopenfilename()

    print('文件路径：', filePath)
    return filePath


top = tkinter.Tk()

B = tkinter.Button(top, text="选择图片文件", command=getLocalFile)
B.pack()

top.mainloop()
