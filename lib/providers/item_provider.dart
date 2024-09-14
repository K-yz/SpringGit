import 'package:flutter/material.dart';
import '../models/item.dart';

class ItemProvider with ChangeNotifier {
  List<Item> _items = [];
  int _nextId = 1;

  List<Item> get items => _items;

  void addItem(String name) {
    _items.add(Item(id: _nextId++, name: name));
    notifyListeners();
  }

  void updateItem(int id, String name) {
    final index = _items.indexWhere((item) => item.id == id);
    if (index != -1) {
      _items[index] = Item(id: id, name: name);
      notifyListeners();
    }
  }

  void deleteItem(int id) {
    _items.removeWhere((item) => item.id == id);
    notifyListeners();
  }
}
