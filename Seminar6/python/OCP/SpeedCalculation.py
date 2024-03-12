class SpeedCalculation:
    
    def calculate_allowed_speed(self, vehicle):
        if vehicle.get_type().lower() == "car":
            return vehicle.get_max_speed() * 0.8
        elif vehicle.get_type().lower() == "bus":
            return vehicle.get_max_speed() * 0.6
        return 0.0