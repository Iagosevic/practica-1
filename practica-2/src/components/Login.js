import React, {useReducer, useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';
import {Password} from "@mui/icons-material";
import {useNavigate} from "react-router-dom";

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),

        },
    },
}));
function Auth(){

    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[user,setUser]=useState('')
    const[pass,setPass]=useState('')
    const[logueado,setLogueado]=useState("no")

    const classes = useStyles();
    const navigate = useNavigate();

    const usersRegistrados = [
        {
            username: "user",
            password: "user"
        },
        {
            username: "admin",
            password: "admin"
        }
    ];

    const handleClick=(e)=>{
        e.preventDefault()
        const usuario={user,pass}
        console.log(usuario)

        //const account = usersRegistrados.find((u) => u.username === user);
        if (usersRegistrados.find((u) => u.username === user) &&
            usersRegistrados.find((u) => u.password === pass)){

            localStorage.setItem("user", usuario.username);
            localStorage.setItem("passwd", usuario.password);
            localStorage.setItem("logueado", "si");
            navigate("/Ciudad");
        }
        else{
            window.alert("Datos incorrectos")
        }
    }

    return(
        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{color:"blue"}}><u>Login</u></h1>

                <form className={classes.root} noValidate autoComplete="off">

                    <TextField id="outlined-basic" label="Usuario" variant="outlined" fullWidth
                               value={user}
                               onChange={(e)=>setUser(e.target.value)}
                    />
                    <TextField id="outlined-basic" type={"password"} label="Contraseña" variant="outlined" fullWidth
                               value={pass}
                               onChange={(e)=>setPass(e.target.value)}
                    />

                    <Button variant="contained" color="secondary" onClick={handleClick}>
                        Iniciar sesión
                    </Button>
                </form>

            </Paper>

        </Container>
    );
}
export default Auth;
