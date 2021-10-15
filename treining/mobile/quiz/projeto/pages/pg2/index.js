import React from 'react';
import { View, Text, Image, TouchableOpacity} from 'react-native';

import styles from './style';

export default function Page2({ navigation }){
    const perg = {
            "imagem":"https://i.pinimg.com/originals/a2/c0/eb/a2c0ebbd3dbfaf1f58e0f4d6d7ae74c4.jpg",
            "pergunta":"Qual país tem a maior expectativa de vida do mundo?",
            "alternativas":["1. Japão", "2. Austrália", "3. Itália", "4. Brasil"] // japao
        }

    const handleNavigate = (page3) => {
        navigation.navigate('Page3', page3) // acessa a terceira pagina
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