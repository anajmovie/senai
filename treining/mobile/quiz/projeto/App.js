import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

const Stack = createNativeStackNavigator();

import Page1 from './pages/pg1';
import Page2 from './pages/pg2';
import Page3 from './pages/pg3';
import Page4 from './pages/pg4';
import Resultado from './pages/resultado';

export default function App(){
    return(
        <NavigationContainer>
            <Stack.Navigator>
                <Stack.Screen name="Page1" component={Page1}/>
                <Stack.Screen name="Page2" component={Page2}/>
                <Stack.Screen name="Page3" component={Page3}/>
                <Stack.Screen name="Page4" component={Page4}/>
                <Stack.Screen name="Resultados" component={Resultado}/>
            </Stack.Navigator>
        </NavigationContainer>
    )
    
}