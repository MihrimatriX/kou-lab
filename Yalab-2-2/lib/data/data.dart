import 'package:cloud_firestore/cloud_firestore.dart';

class Data {
  enUzunMesafeGun() {
    return FirebaseFirestore.instance
        .collection("Trip_Data")
        .orderBy("trip_distance", descending: true)
        .limit(5)
        .get();
  }
}
