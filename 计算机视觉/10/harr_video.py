import numpy as np
import cv2 
from matplotlib import pyplot as plt

path_model=''
face_cascade = cv2.CascadeClassifier(
    path_model + 'haarcascade_frontalface_default.xml'
)
cap = cv2.VideoCapture(0)
while cap.isOpened():
    success , image = cap.read()#按帧读取
    if not success:
        print()
        continue
    faces = face_cascade.detectMultiScale(
        image,
        scaleFactor=1.1,
        minNeighbors=5
    )
    for (x,y,w,h) in faces:
        cv2.rectangle(image,(x,y),(x+w,y+h),(0,0,255),2)
    cv2.imshow('FaceDetection',image)