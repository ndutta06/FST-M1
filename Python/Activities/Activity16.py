class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make,transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + ' is moving')

    def stop(self):
        print(self.manufacturer + " " + self.model + ' has stopped')


c = Car("Toyota", "Corolla", "2015", "Manual", "White")
c.accelerate()
c.stop()
c = Car("Maruti", "800", "2013", "Manual", "Red")
c.accelerate()
c.stop()
c = Car("Suzuki", "Swift", "2017", "Automatic", "Black")
c.accelerate()
c.stop()
del c