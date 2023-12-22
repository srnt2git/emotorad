import { useState } from 'react';

function Login() {
    const [user, setUser] = useState({});
    const handleChange = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        setUser(values => ({ ...values, [name]: value }))
    }
    const CONTEXT = process.env.REACT_APP_CONTEXT;
    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch("/"+CONTEXT +'processLogin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',

                },
                body: JSON.stringify(user),
            });

            if (response.ok) {
                // Handle success, e.g., show a success message
                console.log('Form submitted successfully');
            } else {
                // Handle errors, e.g., show an error message
                console.error('Form submission failed');
            }
        } catch (error) {
            console.error('Error:', error);
        }

    }
    return (
        <form onSubmit={handleSubmit}>
            <table border='1' align='center'>
                <tr align='center'>
                    <td>
                        <label>Enter User name:
                            <input
                                name="userName"
                                value={user.userName}
                                type="text"
                                onChange={handleChange}
                            />
                        </label>
                    </td>
                </tr>
                <tr align='center'>
                    <td>
                        <label>Enter Password:
                            <input
                                name="password"
                                value={user.password}
                                type="text"
                                onChange={handleChange}
                            />
                        </label>
                    </td>
                </tr>
                
                <tr>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>

    )


}
export default Login;