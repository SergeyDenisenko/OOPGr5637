class Cube(Shape3D):
    def init(self, edge):
        self.edge = edge
    
    def area(self):
        return 6 * self.edge * self.edge

    def volume(self):
        return self.edge * self.edge * self.edge