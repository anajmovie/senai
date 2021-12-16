import { StyleSheet } from "react-native";

export default StyleSheet.create({
    container: {
        flex: 1,
        alignItems: "center",
        marginTop: "15px"
    },
    text: {
        textAlign: "center",
        fontSize: 35,
        width: 250,
        padding: "10px",
        fontFamily: "arial"
    },
    icone: {
        width: 30,
        height: 30
    },
    card: {
        border: "1px solid #000",
        borderRadius: '6px',
        padding: "17px",
        width: 290,
        alignItems: "center",
        fontFamily: "arial",
        margin: 7,
        display: "flex",
        flexDirection: "row",
        justifyContent: "space-between"
    },
    endereco: {
        fontWeight: "bold",
        marginLeft: "20px"
    },
    entg: {
        marginTop: "60px",
        fontFamily: "arial",
        fontSize: 20
    }
})