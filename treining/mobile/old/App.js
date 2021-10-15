import React , { useState } from "react";
import { View, Text, TouchableOpacity, TextInput, Image } from "react-native";

import styles from '../proj01/Style.js';

const logo = require('./assets/favicon.png');

export default function App(){
  const [textInput, setTextinput] = useState("");

  const restaurantes = [
    {
      nome:"Paris 6",
      nota:2
    },
    {
      nome:"Outback",
      nota:4.5
    },
    {
      nome:"Gordinho e Paloma",
      nota:7
    },
    {
      nome:"Lindoya Lanches",
      nota:4.7
    }
  ];

  function selectRes(nome){
    setTextinput(nome);
  }

  return (
    <View style={styles.container}>
        <Image style={styles.image}
          source={
            {
              uri: 'https://s4.static.brasilescola.uol.com.br/img/2019/09/panda.jpg'
            }
          }
        />
        <TextInput value={textInput} style={styles.input}
        onChange={(e) => { setTextinput(e.value); }}></TextInput>
        {
          restaurantes.map((item, index) => {
            return(
              <TouchableOpacity key={index} style={styles.card} onPress={() => {
                  selectRes(item.nome)}
                }>
                <Text>{item.nome}</Text>
                <Text>{item.nota}</Text>
              </TouchableOpacity>
            )
          })
        }
    </View>
  );
}