import React, { useEffect, useState } from "react";
import { View, Text, TouchableOpacity, Image } from "react-native";
import style from './style.js'

export default function Entregas({ navigation, route }) {
    const { id_entregador } = route.params
    const [entrega, setEntrega] = useState([
        {
            "id":id_entregador,
            "endereco":""
        }
    ])

    const url = "http://10.87.202.131:3000/entregas/entregadores/" + id_entregador

    useEffect(() => {
        fetch(url, {
            "method":"GET"
        })
        .then(resp => { return resp.json()
        })
        .then(data => { setEntrega(data)
        })
        .catch(err => {})
    }, [entrega])

    return(
        <View style={style.container}>
            <Text style={style.text}>Entregas</Text>
            <View style={style.entg}>
                {entrega.map((item, index) => 
                    <TouchableOpacity key={index} style={style.card} onPress={() => { navigation.navigate("Detalhes", item) }}>
                        <Image style={style.icone} source={require('../../assets/motoboy.png')}/>
                        <Text style={style.endereco}>{item.endereco}</Text>
                    </TouchableOpacity>
                )}
            </View>
        </View>
    )
}