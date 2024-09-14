class Item {
  int id;
  String name;

  Item({required this.id, required this.name});

  // Convert an Item into a Map. The keys must correspond to the names of the columns in your database.
  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
    };
  }

  // Extract an Item object from a Map.
  factory Item.fromMap(Map<String, dynamic> map) {
    return Item(
      id: map['id'],
      name: map['name'],
    );
  }
}
