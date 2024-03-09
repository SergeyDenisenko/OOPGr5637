class Vehicle:
    
    def __init__(self, max_speed, type):
        self.max_speed = max_speed
        self.type = type

    def get_max_speed(self):
        return self.max_speed
        
    def get_type(self):
        return self.type