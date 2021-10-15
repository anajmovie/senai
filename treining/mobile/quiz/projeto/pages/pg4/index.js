import React from 'react';
import { View, Text, Image, TouchableOpacity} from 'react-native';

import styles from './style';

export default function Page4({ navigation }){
    const perg = {
            "imagem":"https://vemvoar.voeazul.com.br/wp-content/uploads/2018/07/asia-cultura-historia-e-os-principais-paises-e-cidades-para-se-visitar.jpeg",
            "pergunta":"Em qual local da Ásia o português é língua oficial?",
            "alternativas":["1. Índia", "2. Filipinas", "3. Macau", "4. Portugal"] // macau
        }

    const handleNavigate = (resultado) => {
        navigation.navigate('Resultados', resultado) // acessa a pagina de resultados
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