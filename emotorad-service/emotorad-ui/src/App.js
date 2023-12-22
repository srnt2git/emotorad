import './App.css';
import Main from './jsx/main.jsx'
import { ErrorProvider } from './jsx/errorContext.jsx';
import { JwtProvider } from './jsx/jwtcontext';
import './css/globalStyles.css';


function App() {
    return (
        <JwtProvider>
            <ErrorProvider>
                <Main />
            </ErrorProvider>
        </JwtProvider>

    );
}

export default App;