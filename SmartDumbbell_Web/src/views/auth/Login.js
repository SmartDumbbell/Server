import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Box, Card, Stack, Typography, Grid } from '@mui/material';
import PageContainer from '../../components/container/PageContainer';
import AuthLogin from './base/AuthLogin';
import LoginImg from '../../assets/images/WebSystem_Main.png'; // 이미지 경로 추가

const Login = () => {
    return (
        <PageContainer title="Login" description="this is Login page">
            <Box
                sx={{
                    position: 'relative',
                    '&:before': {
                        content: '""',
                        background: 'radial-gradient(#d2f1df, #d3d7fa, #bad8f4)',
                        backgroundSize: '400% 400%',
                        animation: 'gradient 15s ease infinite',
                        position: 'absolute',
                        height: '100%',
                        width: '100%',
                        opacity: '0.3',
                    },
                }}
            >
                <Grid container spacing={0} justifyContent="center" sx={{ height: '100vh' }}>
                    <Grid item xs={12} sm={12} lg={4} xl={3} display="flex" justifyContent="center" alignItems="center">
                        <Card elevation={9} sx={{ p: 4, zIndex: 1, width: '100%', maxWidth: '500px' }}>
                            <Box display="flex" alignItems="center" justifyContent="center" mb={2}>
                                <img src={LoginImg} style={{ width: '100%', height: 'auto' }} alt="스마트 덤벨 관리자 시스템" />
                            </Box>
                            <Box display="flex" alignItems="center" justifyContent="center">
                                스마트 덤벨 관리자 시스템
                            </Box>
                            <AuthLogin
                                subtitle={
                                    <Stack direction="row" spacing={1} justifyContent="right" mt={3}>
                                        <Typography
                                            component={Link}
                                            to="/signup"
                                            fontWeight="500"
                                            sx={{
                                                textDecoration: 'none',
                                                color: 'primary.main',
                                            }}
                                        >
                                            회원가입
                                        </Typography>
                                    </Stack>
                                }
                            />
                        </Card>
                    </Grid>
                </Grid>
            </Box>
        </PageContainer>
    );
};

export default Login;
