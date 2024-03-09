class Shape:
    width = 0
    height = 0

    @abstractmethod
    def setWidth(self, width):
        pass

    @abstractmethod
    def setHeight(self, height):
        pass

    def area(self):
        return self.width * self.height;