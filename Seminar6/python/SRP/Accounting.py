class Accounting:
    def __init__(self, base_salary):
        self.base_salary = base_salary
        self.ratio = 0.25

    def calculateNetSalary():
        tax = int(self.base_salary * ratio)
        return self.base_salary - tax

    def giveOutSalary(self, emp: Employee):
        emp.takeSalary(self.calculateNetSalary())