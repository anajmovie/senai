import { StyleSheet } from "react-native";

export default StyleSheet.create({
    container: {
        flex: 1,
        alignItems: "center",
        marginTop: "15px"
    },
    msg: {
        textAlign: "center",
        fontSize: 30,
        width: 250,
        padding: "10px",
        fontFamily: "arial"
    },
    item: {
        border: "1px solid #000",
        borderRadius: '6px',
        padding: "10px",
        width: 230,
        alignItems: "center",
        fontFamily: "arial",
        margin: 7,
        display: "flex",
        flexDirection: "column"
    },
    icone: {
        width: 30,
        height: 30
    },
    indent: {
        marginTop: "60px",
        fontFamily: "arial",
        fontSize: 20
    },
    entregadores: {
        marginTop: "50px"
    }
})