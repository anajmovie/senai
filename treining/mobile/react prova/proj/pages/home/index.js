import React, { useEffect, useState } from "react";
import { View, Text, TouchableOpacity, Image } from "react-native";
import style from './style.js';

export default function Home({ navigation }) {
    const [entregador, setEntregador] = useState([
        {
            "nome":""
        }
    ])

    let url = "http://10.87.202.131:3000/entregas/entregadores";

    useEffect(() => {
        fetch(url, {
            "method":"GET"
        })
        .then(resp => { return resp.json()
        })
        .then(data => { setEntregador(data)
        })
        .catch(err => {})
    }, [entregador])

    return (
        <View style={style.container}>
            <Text style={style.msg}>Selecione qual motoboy você é:</Text>
            <View style={style.entregadores}>
            {entregador.map((item, index) =>
                <TouchableOpacity key={index} style={style.item} onPress={() => { navigation.navigate("Entregas", item) }}>
                    <Image style={style.icone} source={require('../../assets/person.png')}/>
                    <Text>{item.nome}</Text>
                </TouchableOpacity>
            )}
            </View>
            <Text style={style.indent}>Por favor, se identificar.</Text>
        </View>
    )
}