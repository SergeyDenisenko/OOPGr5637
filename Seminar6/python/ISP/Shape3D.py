from abc import ABC, abstractmethod
import math
​
class Shape3D(ABC):
    @abstractmethod
    def area(self):
        pass
        
    @abstractmethod
    def volume(self):
        pass