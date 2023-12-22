import { useState } from "react";
import { post } from './httpClient'
import { useJwt } from './jwtcontext';


export default function PostMessage({ closeDialog }) {
    const [s, setSpeed] = useState(0);
    const { getJwt } = useJwt();
    const postMessage = () => {
        const req = {
            'speed': s
           
        }
        console.log(s)
        post('message/postMessage', req, (data) => {
          
        }, (err) => {
           
        }, getJwt());
        closeDialog();
    }
    return (<>
        <table>
            <thead>
                <tr>
                    <th colSpan="2">Message</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Speed</td>
                    <td><input onChange={(e) => setSpeed(e.target.value)}></input></td>
                </tr>
                <tr>
                  <td colSpan="2" align="center"><button onClick={ postMessage}>Post</button></td>
                </tr>
            </tbody>
        </table>
    </>);
}