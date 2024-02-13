import sys
from PyQt5.QtWidgets import QApplication

from typing import List
from Domain.bottle import Bottle
from Domain.product import Product
from Domain.hot_drink import HotDrink
from Services.coin_dispenser import CoinDispenser
from Services.display import Display
from Services.holder import Holder
from Services.vending_machine import VendingMachine
from main_frame import MainFrame


if __name__ == "__main__":
    assort: List[Product] = []
    item1 = Product(100, 1, "Lays")
    item2 = Product(50, 2, "Cola")
    item3 = Bottle(150, 3, "Mineral Water", 101, 1.5)
    item4 = HotDrink(75, 4, "Coffe", 201, 65)
    item5 = HotDrink(150, 5, "Latte", 202, 70)
    item6 = HotDrink(140, 46, "Cappuccino", 203, 60)
    assort.append(item1)
    assort.append(item2)
    assort.append(item3)
    assort.append(item4)
    assort.append(item5)
    assort.append(item6)


    hold1 = Holder(4, 4)
    coinDesp = CoinDispenser(0)
    disp = Display()

    venMachine = VendingMachine(hold1, coinDesp, assort, disp)

    for prod in venMachine.getProducts():
        print(prod)


    app = QApplication(sys.argv)
    myFrame = MainFrame()
    myFrame.show()
    sys.exit(app.exec_())

    #print("Hello, World!")