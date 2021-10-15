import React from 'react';
import { View, Text, Image, TouchableOpacity} from 'react-native';

import styles from './style';

export default function Page1({ navigation }){
    const perg = {   
            "imagem":"https://conhecimentocientifico.r7.com/wp-content/uploads/2019/08/rene-descartes.jpg",
            "pergunta":"De quem é a frase 'Penso, logo existo'?",
            "alternativas":["1. Platão","2. Galileu Galilei","3. Descartes","4. Sócrates"] // descartes
        }
    
    
    const handleNavigate = (page2) => {
        navigation.navigate('Page2', page2) // acessa a segunda pagina
    }

    return(
        <View>            
            <Image source={perg.imagem} style={{width: '100vw', height: '20vh'}} />
            <Text style={styles.pergunta}>{perg.pergunta}</Text> 
            {
            perg.alternativas.map((perguntas, index) => { // percorre o vetor de alternativas todo
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