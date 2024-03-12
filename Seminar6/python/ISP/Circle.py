class Circle(Shape):
    def init(self, radius):
        self.radius = radius

    def area(self):
        return 2 * math.pi * self.radius