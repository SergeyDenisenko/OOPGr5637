from datetime import date

class Employee:
    salary = 0

    def __init__(self, name, dob):
        self.name = name
        self.dob = dob

    def get_emp_info(self):
        return f"name - {self.name} , dob - {self.dob}"

    def takeSalary(self, salary):
        self.salary = salary