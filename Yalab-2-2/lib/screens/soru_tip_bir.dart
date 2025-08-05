import 'package:flutter/material.dart';
import 'package:flutter_app/data/data.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class SorguTipBir extends StatefulWidget {
  @override
  _SorguTipBirState createState() => _SorguTipBirState();
}

class _SorguTipBirState extends State<SorguTipBir> {
  bool revFlag = false;
  var revs;

  @override
  void initState() {
    super.initState();
    Data().enUzunMesafeGun().then((QuerySnapshot datas) {
      if (datas.docs.isNotEmpty) {
        revFlag = true;
        revs = datas.docs[0].data();
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    Future<QuerySnapshot> users =
        FirebaseFirestore.instance.collection('Trip_Data').orderBy("trip_distance", descending: true).limit(5).get();

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
                  subtitle:
                      new Text(document.data()['tpep_pickup_datetime'].toString()),
                );
              }).toList(),
            );
          },
        ),
      ),
    );
  }
}
