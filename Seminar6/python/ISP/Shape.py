from abc import ABC, abstractmethod
import math
​
class Shape(ABC):
    @abstractmethod
    def area(self):
        pass