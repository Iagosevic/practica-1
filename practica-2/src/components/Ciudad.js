import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),

        },
    },
}));

export default function Ciudad() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[nombreciudad,setNombreCiudad]=useState('')
    const[idpais,setIdPais]=useState('')
    const[valorciudad,setValorCiudad]=useState([''])
    const[ciudades,setCiudades]=useState([])
    const classes = useStyles();

    const handleClick=(e)=>{
        e.preventDefault()
        const ciudades={nombreciudad,idpais, valorciudad}
        console.log(ciudades)
        fetch("http://localhost:8080/ciudades/",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(ciudades)

        }).then(()=>{
            console.log("Nueva ciudad añadida")
        })
    }

    useEffect(()=>{
        fetch("http://localhost:8080/ciudades")
            .then(res=>res.json())
            .then((result)=>{
                    setCiudades(result);
                }
            )
    },[])
    return (

        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{color:"blue"}}><u>Insertar ciudad</u></h1>

                <form className={classes.root} noValidate autoComplete="off">

                    <TextField id="outlined-basic" label="Nombre ciudad" variant="outlined" fullWidth
                               value={nombreciudad}
                               onChange={(e)=>setNombreCiudad(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="ID pais" variant="outlined" fullWidth
                               value={idpais}
                               onChange={(e)=>setIdPais(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Valor ciudad" variant="outlined" fullWidth
                               value={valorciudad}
                               onChange={(e)=>setValorCiudad(e.target.value)}
                    />
                    <Button variant="contained" color="secondary" onClick={handleClick}>
                        Submit
                    </Button>
                </form>

            </Paper>

        </Container>
    );
}