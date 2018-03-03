# -*- coding: utf-8 -*-
import os
import sys
import math
import string
import random
import pandas
import time

import pylab
import  numpy as np


def get_file_info(file_name):
    pos_info = file_name.split('/')[-1].lstrip('android_')                                 #把/分割开来，及第二个数字，删除左边andriod
    pos_info = pos_info.split('_')

    start_pos = pos_info[0]
    end_pos = pos_info[2]
    direct = pos_info[-1].split('.')[0]
    floors = pos_info[-2]

    if floors.find('F') != -1:
        floors = floors.strip('F')

    if floors.find('B') != -1:
        floors = '-' + floors.strip('B')

    l = start_pos.find('(') + 1
    r = start_pos.find(')')

    plaza = start_pos[0:l - 1]

    pos = start_pos[l:r].split(',')
    start_x = float(pos[0])
    start_y = float(pos[1])

    l = end_pos.find('(') + 1
    r = end_pos.find(')')

    pos = end_pos[l:r].split(',')

    end_x = float(pos[0])
    end_y = float(pos[1])

    return plaza, start_x, start_y, end_x, end_y, floors


# 获取文件夹下所有的excel文件列表
def get_file_list(paths):
    paths = paths.rstrip('/')
    ret_files = []
    files = os.listdir(paths)
    for f in files:
        f = paths + '/' + f
        if os.path.isfile(f):
            shotname, extension = os.path.splitext(f)

            if extension == '.xls' or extension == '.xlsx' or extension == '.csv':
                ret_files.append(f)
        else:
            ret_files += get_file_list(f)

    return ret_files


def load_print(file_path, isandroid=False):
    x_values = []
    y_values = []
    file = open(file_path)
    for line in file.readlines():
        tensor = line.strip().split('#')

        if len(tensor) < 10:
            continue

        x = [float(i) for i in tensor[0:-1]]
        y = tensor[-1]

        po = y.split('_')

        if len(po) == 3:
            y = '_'.join([po[0], po[1], po[2]])

        elif len(po) == 4:
            y = '_'.join([po[0], po[1], po[3]])
        else:
            pass

        x_values.append(x)
        y_values.append(y)

    return x_values, y_values


def load_print2(file_path, isandroid=False):
    x_values = []
    y_values = []
    file = open(file_path)
    for line in file.readlines():
        tensor = line.strip().split('#')

        if len(tensor) < 10:
            continue

        x = [float(i) for i in tensor[0:-1]]
        y = tensor[-1]

        po = y.split('_')

        if isandroid:
            # android to iphone
            po[0] = str(float(po[0]) + 21.5)
            po[1] = str(-(float(po[1]) + 17.5))

        if len(po) == 3:
            y = '_'.join([po[0], po[1], '0', po[2]])

        elif len(po) == 4:
            y = '_'.join([po[0], po[1], po[2], po[3]])


        else:
            pass

        x_values.append(x)
        y_values.append(y)

    return x_values, y_values


# 找到距离最近的指纹点,找到tensor中距离find_xy最近的点，并返回指纹，如果距离过大可能返回空
# floor != 0  会进行楼层过滤

def find_nearest_pos(tensor_x, tensor_y, find_x, find_y, floor=0, max_distance=99999.0):
    prints = []
    finded_x = None
    finded_y = None

    for i in range(0, len(tensor_y)):

        y_info = tensor_y[i].split('_')
        x = float(y_info[0])
        y = float(y_info[1])

        if len(y_info) == 3:
            floors = float(tensor_y[i].split('_')[2])
        else:
            floors = 0

        if floor != 0 and floors != floor:
            continue

        distance = ((find_x - x) ** 2 + (find_y - y) ** 2) ** 0.5

        if distance < max_distance:
            max_distance = distance
            prints = tensor_x[i]
            finded_x = x
            finded_y = y

    return prints, finded_x, finded_y


# 找到最近的的指纹对,便利left中的指纹在right中找到最近的xy点，并返回两者的指纹

def find_nearest_pair(left_x, left_y, right_x, right_y):
    train_x = []
    train_y = []

    for i in range(0, len(left_x)):
        x = float(left_y[i].split('_')[0])
        y = float(left_y[i].split('_')[1])
        floor = float(left_y[i].split('_')[2])

        min_dis = 9999999.0
        min_y = 0

        for j in range(0, len(right_x)):
            x1 = float(right_y[j].split('_')[0])
            y1 = float(right_y[j].split('_')[1])
            floor1 = float(right_y[j].split('_')[2])

            if floor != floor1:
                continue

            now_dis = ((x - x1) ** 2 + (y - y1) ** 2) ** 0.5

            if now_dis < min_dis:
                min_dis = now_dis
                min_y = right_x[j]
                if now_dis == 0:
                    break

        if min_dis < 5:
            train_x.append(left_x[i])
            train_y.append(min_y)
        else:
            pass
            # print min_dis, left_y[i]

    return train_x, train_y
