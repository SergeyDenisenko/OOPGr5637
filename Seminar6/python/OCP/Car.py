class Car(Vehicle):
    def __init__(self, max_speed):
        super().__init__(max_speed, "Car")

    def calculateAllowedSpeed(self):
        return self.get_max_speed() * 0.8