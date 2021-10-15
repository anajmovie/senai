import React from 'react';
import { View, Text, Image, TouchableOpacity} from 'react-native';

import styles from './style';

export default function Page3({ navigation }){
    const perg = {
            "imagem":"https://blogdescalada.com/wp-content/uploads/2017/07/pico-agulhas-negras-1.jpg",
            "pergunta":"Qual a montanha mais alta do Brasil?",
            "alternativas":["1. Pico da Neblina", "2. Pico Paraná", "3. Monte Roraima", "4. Pico da Bandeira"] // pico da neblina
        }

    const handleNavigate = (page4) => {
        navigation.navigate('Page4', page4) // acessa a quarta pagina
    }

    return(
        <View>
            <Image source={perg.imagem} style={{width: '100vw', height: '20vh'}} />
            <Text style={styles.pergunta}>{perg.pergunta}</Text>
            {
            perg.alternativas.map((perguntas, index) => { // percorre o vetor todo de alternativas
                return(
                    // após pressionar os bototes passará para outra página
                    <TouchableOpacity onPress={() => {handleNavigate(perguntas)}} key={index}>
                        <Text style={styles.respostas}>{perguntas}</Text>
                    </TouchableOpacity>
                )
            })
        }
        </View>
    )
}