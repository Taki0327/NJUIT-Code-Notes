import numpy as np
from skimage.io import imread
from skimage.color import rgb2gray
from skimage.transform import resize
from skimage.feature import hog
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import classification_report, accuracy_score
from glob import glob
from matplotlib import pyplot as plt

images, hog_images = [], []
X, y = [], []
ppc = 16
sz = 200
for dir in glob('hog-imga_classification_20211210_074736/101_ObjectCategories/*'): #提取每副图像的标签
    image_files = glob(dir + '/*.jpg')
    label = dir.split('\\')[-1]
    print(label, len(image_files))

    for image_file in image_files:
        image = resize(imread(image_file), (sz, sz))#缩放 调整为200*200

        if len(image.shape) != 2:  # if a gray-scale image 
            image = rgb2gray(image) #转换为黑白降低计算量
        
        #hog特征
        fd, hog_image = hog(image,  
                            orientations=8, #8个方向
                            pixels_per_cell=(ppc, ppc),#网格划分 16*16
                            cells_per_block=(4, 4), #块BLOCK
                            block_norm='L2', #正则化
                            visualize=True) #展示HOG

        images.append(image)
        hog_images.append(hog_image) #函数hog输出的图像
        X.append(fd) #特征向量 描述符
        y.append(label) #标签

X = np.array(X)
y = np.array(y)


indices = np.arange(len(X))
#sk-Learn 逻辑回归
#X特征描述符 Y标签 id编号
X_train, X_test, y_train, y_test, id_train, id_test = train_test_split(X, y, indices, test_size=0.1, random_state=1)


clf = LogisticRegression(C=1000, random_state=0, solver='lbfgs',  multi_class='multinomial')
clf.fit(X_train, y_train)#拟合


y_pred = clf.predict(X_test)#预测


print("Accuracy: " + str(accuracy_score(y_test, y_pred)))
print('\n')
# Accuracy: 0.7439024390243902
print(classification_report(y_test, y_pred))#分类报告

plt.figure(figsize=(20, 20))
j = 0
for i in id_test:
    plt.subplot(12, 12, j+1), plt.imshow(images[i], 'gray'), plt.axis('off')
    plt.title('{}/{}'.format(y_test[j], y_pred[j]))
    j += 1

plt.suptitle('Actual vs. Predicted Class Labels', size=20)
plt.tight_layout()
plt.savefig("result.png", dpi=300)
