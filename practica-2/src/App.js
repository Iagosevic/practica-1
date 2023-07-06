import {BrowserRouter, Route, Router, Routes} from 'react-router-dom';
import './App.css';
import Ciudad from './components/Ciudad.js'
import Login from "./components/Login.js";

export default function App(){
    return(

        <div>
            <Routes>

                <Route path="/" element={<Login />}></Route>
                <Route path="/ciudad" element={<Ciudad />}></Route>
            </Routes>
        </div>

    );
}