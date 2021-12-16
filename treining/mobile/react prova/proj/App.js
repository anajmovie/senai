import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";

const Stack = createNativeStackNavigator();

import Home from './pages/home/index.js';
import Entregas from './pages/entregas/index.js';
import Detalhes from './pages/detalhes/index.js'

export default function App() {
  return(
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Delivery" component={Home} />
        <Stack.Screen name="Entregas" component={Entregas} />
        <Stack.Screen name="Detalhes" component={Detalhes} />
      </Stack.Navigator>
    </NavigationContainer>
  )
}