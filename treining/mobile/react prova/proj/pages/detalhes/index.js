import React, { useEffect, useState } from "react";
import { View, Text, TouchableOpacity, Touchable } from "react-native";
import style from './style.js';

export default function Detalhes({ navigation, route }) {
    const { id_entregador } = route.params
    const [delivery, setDelivery] = useState([
        {
            "id":id_entregador,
            "cliente":"",
            "endereco":"",
            "produto":"",
            "valor":0
        }
    ])

    let url = "http://10.87.202.131:3000/entregas/entregadores/" + id_entregador

    useEffect(() => {
        fetch(url, {
            "method":"GET"
        })
        .then(resp => { return resp.json()
        })
        .then(data => { setDelivery(data) 
        })
        .catch(err => {})
    }, [delivery])

    return(
        <View style={style.container}>
            <Text style={style.text}>Detalhes do Pedido</Text>
            <View style={style.contseg}>
            {delivery.map((item, index) => 
                    <TouchableOpacity key={index} style={style.card}>
                        <Text style={style.font}>{item.cliente}</Text>
                        <Text style={style.font}>{item.endereco}</Text>
                        <Text style={style.font}>{item.produto}</Text>
                        <Text style={style.font}>{item.valor}</Text>
                    </TouchableOpacity>
                )}
            </View>
            <TouchableOpacity>
                    <Text style={style.botao}>Pedido entregue</Text>
                </TouchableOpacity>
        </View>
        
        
    )
}