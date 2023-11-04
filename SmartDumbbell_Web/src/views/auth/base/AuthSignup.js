import React, { useState } from 'react';
import { Box, Typography, Button } from '@mui/material';
import {Link, useNavigate} from 'react-router-dom';

import { Stack } from '@mui/system';
import {Input} from "reactstrap";

const AuthRegister = ({ title, subtitle, subtext }) => {
    const [selectedRole, setSelectedRole] = useState('');
    const [selectedGender, setSelectedGender] = useState('');

    const handleRoleChange = (event) => {
        setSelectedRole(event.target.value);
    };
    const navigate = useNavigate();
    const handleGenderChange = (event) => {
        setSelectedGender(event.target.value);
    };

    // 각 입력 필드에 대한 상태와 업데이트 함수 정의
    const [id, setId] = useState('');
    const [name, setName] = useState('');
    const [birthday, setBirthday] = useState('');
    const [email, setEmail] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [institution, setInstitution] = useState('');

    const handleIdChange = (event) => {
        setId(event.target.value);
    };

    const handleNameChange = (event) => {
        setName(event.target.value);
    };

    const handleBirthdayChange = (event) => {
        setBirthday(event.target.value);
    };

    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    };

    const handlePhoneNumberChange = (event) => {
        setPhoneNumber(event.target.value);
    };

    const handleInstitution = (event) => {
        setInstitution(event.target.value);
    };


    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [passwordsMatch, setPasswordsMatch] = useState(true);

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
        setPasswordsMatch(confirmPassword === event.target.value);
    };

    const handleConfirmPasswordChange = (event) => {
        setConfirmPassword(event.target.value);
        setPasswordsMatch(password === event.target.value);
    };

    const handleSubmit = async () => {
        if (passwordsMatch) {
            try {
                const response = await fetch('http://localhost:8080/auth/signup', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({role:"USER",name:name,birth:birthday,gender:selectedGender,email:email,phone:phoneNumber, password:password, institution:institution}),
                    mode: 'cors'
                });

                if (response.ok) {
                    response.json().then(data => {
                        navigate('/login');
                    }).catch(error => {
                        console.error('JSON 파싱 오류:', error);
                    });
                } else {
                    console.error('회원가입 실패');
                }

            } catch (error) {
                console.error('오류 발생:', error);
            }
            console.log('회원 가입 정보 전송');

        } else {

            console.log('비밀번호가 일치하지 않습니다.');
        }
    };
    return (
        <>
            {title ? (
                <Typography fontWeight="700" variant="h2" mb={1}>
                    {title}
                </Typography>
            ) : null}

            {subtext}

            <Box>
                <Stack mb={5}>
                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="email" mb="5px" mt="25px">
                        이메일
                    </Typography>
                    <Input id="email" variant="outlined" fullWidth value={email} onChange={handleEmailChange} />

                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="password" mb="5px" mt="25px">
                        비밀번호
                    </Typography>
                    <Input
                        id="password"
                        type="password"
                        variant="outlined"
                        fullWidth
                        value={password}
                        onChange={handlePasswordChange}
                    />

                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="setPassword" mb="5px" mt="25px">
                        비밀번호 확인
                    </Typography>
                    <Input
                        id="confirm_password"
                        type="password"
                        variant="outlined"
                        fullWidth
                        value={confirmPassword}
                        onChange={handleConfirmPasswordChange}
                    />

                    {!passwordsMatch && (
                        <Typography color="error" variant="body2">
                            비밀번호가 일치하지 않습니다.
                        </Typography>
                    )}

                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="division" mb="5px" mt="25px">
                        소속
                    </Typography>

                    <Input id="institution" variant="outlined" fullWidth value={institution} onChange={handleInstitution} />

                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="name" mb="5px" mt="25px">
                        이름
                    </Typography>
                    <Input id="name" variant="outlined" fullWidth value={name} onChange={handleNameChange} />

                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="birthday" mb="5px" mt="25px">
                        생년월일
                    </Typography>
                    <Input id="birthday" variant="outlined" fullWidth value={birthday} onChange={handleBirthdayChange} />

                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="gender" mb="5px" mt="25px">
                        성별
                    </Typography>
                    <div style={{ display: 'flex', gap: '10px' }}>
                        <label>
                            <input
                                type="checkbox"
                                value="male"
                                checked={selectedGender === 'male'}
                                onChange={handleGenderChange}
                            />
                            남성
                        </label>
                        <span style={{ margin: '0 56px' }}></span>
                        <label>
                            <input
                                type="checkbox"
                                value="female"
                                checked={selectedGender === 'female'}
                                onChange={handleGenderChange}
                            />
                            여성
                        </label>
                    </div>

                    <Typography variant="subtitle1" fontWeight={600} component="label" htmlFor="phone_number" mb="5px" mt="25px">
                        휴대전화
                    </Typography>
                    <Input id="phone_number" variant="outlined" fullWidth value={phoneNumber} onChange={handlePhoneNumberChange} />

                </Stack>
                <Button
                    color="primary"
                    variant="contained"
                    size="large"
                    fullWidth
                    component={Link}
                    to="/login"
                    disabled={!passwordsMatch}
                    onClick={handleSubmit}
                >
                    Sign Up
                </Button>
            </Box>
            {subtitle}
        </>
    );
};

export default AuthRegister;