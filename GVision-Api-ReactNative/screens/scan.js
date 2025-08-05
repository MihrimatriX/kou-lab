import React, {Component, Fragment} from 'react';
import {RNCamera} from 'react-native-camera';
import styles from './scanStyle';
import {
  TouchableOpacity,
  Text,
  StatusBar,
  ScrollView,
  View,
  ActivityIndicator,
} from 'react-native';

const Scan = (props) => {
  const {
    camera,
    cameraResult,
    clickAgain,
    takePicture,
    activeCamera,
    googleVisionDetetion,
    loading,
  } = props;
  const desccription =
    'Cloud Vision API, geliştiricilerin görüntü etiketleme, yüz ve yer işareti algılama, optik karakter tanıma (OCR) dahil olmak üzere görsel algılama özelliklerini uygulamalar içinde kolayca entegre etmelerine olanak tanır.';
  return (
    <View style={styles.scrollViewStyle}>
      {/* Uygulama Başlatıldığında Görüntülenecek Fragment */}
      <Fragment>
        <StatusBar barStyle="dark-content" />
        <Text style={styles.textTitle}>Google Vision Nesne Bulucu</Text>
        {!camera && !cameraResult && (
          <View style={styles.cardView}>
            <Text numberOfLines={8} style={styles.descText}>
              {desccription}
            </Text>

            <TouchableOpacity
              onPress={activeCamera}
              style={styles.buttonTouchable}>
              <Text style={styles.buttonTextStyle}>Kameradan Tarama Yapın</Text>
            </TouchableOpacity>
          </View>
        )}
        {!googleVisionDetetion && loading && (
          <View style={styles.SpinnerStyle}>
            <ActivityIndicator size={props.size || 'large'} />
            <Text style={{color: 'white', fontSize: 18, fontWeight: 'bold'}}>
              Cloud Verisi Bekliyor.
            </Text>
          </View>
        )}
        {/* Clouddan Düzgün Mesaj Dönünce */}
        {googleVisionDetetion && (
          <Fragment>
            <Text style={styles.textTitle1}>Bulunan Sonuçlar :</Text>

            <View
              style={
                googleVisionDetetion ? styles.scanCardView : styles.cardView
              }>
              <ScrollView>
                {googleVisionDetetion.webDetection.webEntities.map(
                  (data, index) => {
                    return (
                      <View
                        key={index}
                        style={{
                          borderWidth: 2,
                          borderColor: 'black',
                          margin: 10,
                        }}>
                        <Text>entityId : {data.entityId}</Text>
                        <Text>score : {data.score}</Text>
                        <Text numberOfLines={1}>
                          description: {data.description}
                        </Text>
                      </View>
                    );
                  },
                )}
              </ScrollView>
            </View>

            <TouchableOpacity
              onPress={clickAgain}
              style={styles.buttonTouchable}>
              <Text style={styles.buttonTextStyle}>Tekrar Tarayın</Text>
            </TouchableOpacity>
          </Fragment>
        )}

        {/* React Native Camera Görünümü */}
        {camera && (
          <View style={styles.container}>
            <RNCamera
              ref={(ref) => {
                this.camera = ref;
              }}
              style={styles.preview}
              type={RNCamera.Constants.Type.back}
              flashMode={RNCamera.Constants.FlashMode.off}
              androidCameraPermissionOptions={{
                title: 'Kamera Kullanım İzni',
                message: 'Kamera İçin İzne İhtiyacımız Var.',
                buttonPositive: 'TAMAM',
                buttonNegative: 'İPTAL',
              }}
              androidRecordAudioPermissionOptions={{
                title: 'Ses Kullanım İzni',
                message: 'Ses İçin İzne İhtiyacımız Var.',
                buttonPositive: 'TAMAM',
                buttonNegative: 'İPTAL',
              }}
              onGoogleVisionBarcodesDetected={({barcodes}) => {
                console.log(barcodes);
              }}
            />
            {/* Basınca Resim Çek */}
            <View
              style={{flex: 0, flexDirection: 'row', justifyContent: 'center'}}>
              <TouchableOpacity
                onPress={() => takePicture(this.camera)}
                style={styles.capture}>
                <Text style={{fontSize: 14}}> Resim Çekin </Text>
              </TouchableOpacity>
            </View>
          </View>
        )}
      </Fragment>
    </View>
  );
};

export default Scan;
