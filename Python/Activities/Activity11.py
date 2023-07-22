# fruit_shop activity
fruittocheck = input('Enter the fruit name to check available :')
fruit_shop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}
if( fruittocheck in fruit_shop):
    print(fruittocheck +' is available')
else:
    print(fruittocheck +' is not available')
