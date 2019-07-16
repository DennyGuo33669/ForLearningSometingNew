var book = {
  _year: 2004,
  edition: 1
};

Object.defineProperty(book, 'some', {
  get: function () {
    return this._year;
  },
  set: function (newValue) {
    if (newValue > 2004) {
      this._year = newValue;
      this.edition += newValue - 2004;
    }
  }
});

book.some = 3005;
console.log(book.edition); // 2
