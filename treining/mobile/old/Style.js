import { StyleSheet } from 'react-native';

export default StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#8e44ad',
        alignItems: 'center',
        justifyContent: 'center'
    },
    title: {
        fontSize: '2rem',
        color: '#feca57'
    },
    card: {
        width: '90%',
        height: '10%',
        backgroundColor: '#8395a7',
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-around',
        borderRadius: '10px',
        marginTop: '1%'
    },
    input: {
        backgroundColor: "#fff",
        width: '50vw',
        height: '5vh',
        borderRadius: '10px' 
    },
    image: {
        width: 80,
        height: 80
    }
});