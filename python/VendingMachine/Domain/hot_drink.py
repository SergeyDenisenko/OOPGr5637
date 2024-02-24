from Domain.product import Product

class HotDrink(Product):
    def __init__(self, price, place, name, id):
        super().__init__(price, place, name, id)
        self.temperature = 0.0

    def __init__(self, price, place, name, id, temperature):
        super().__init__(price, place, name, id)
        self.temperature = temperature

    def getHotDrinkTemperature(self):
        return self.temperature
    
    def setHotDrinkTemperature(self, temperature):
        self.temperature = temperature

    def __str__(self):
        return super().__str__() + "\ntemperature=" + str(self.temperature)