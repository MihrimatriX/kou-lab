import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:flutter/material.dart';

class SoruTipIki extends StatefulWidget {
  SoruTipIki(String tipIkiTarihBir, String tipIkiTarihIki);

  @override
  _SoruTipIkiState createState() => _SoruTipIkiState();
}

class _SoruTipIkiState extends State<SoruTipIki> {

  String tarih1;
  String tarih2;

  SoruTipIki(String tipIkiTarihBir, String tipIkiTarihIki)
  {
    this.tarih1 = tipIkiTarihBir;
    this.tarih2 = tipIkiTarihIki;
  }

  @override
  Widget build(BuildContext context) {
    Future<QuerySnapshot> users = FirebaseFirestore.instance
        .collection('Trip_Data')
        .where('tpep_pickup_datetime', isGreaterThanOrEqualTo: tarih1)
        .where('tpep_pickup_datetime', isLessThanOrEqualTo: tarih2)
        .orderBy("trip_distance", descending: false)
        .limit(5)
        .get();

    print("$tarih1  ---  $tarih2");

    return Scaffold(
      appBar: AppBar(
        title: Center(child: Text("Sonuc Ekranı")),
      ),
      body: Container(
        child: StreamBuilder<QuerySnapshot>(
          stream: users.asStream(),
          builder:
              (BuildContext context, AsyncSnapshot<QuerySnapshot> snapshot) {
            if (snapshot.hasError) {
              return Text('Something went wrong');
            }

            if (snapshot.connectionState == ConnectionState.waiting) {
              return Text("Loading");
            }

            return new ListView(
              children: snapshot.data.docs.map((DocumentSnapshot document) {
                return new ListTile(
                  title: new Text(document.data()['trip_distance'].toString()),
                  subtitle: new Text(document.data()['fare_amount'].toString()),
                );
              }).toList(),
            );
          },
        ),
      ),
    );
  }
}
