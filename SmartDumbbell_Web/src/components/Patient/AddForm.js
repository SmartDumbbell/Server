import React, { useState, useRef } from 'react';
import { Card, CardBody, CardTitle, Form, FormGroup, Label, Input, Button, Row, Col } from 'reactstrap';
import defaultImage from '../../assets/images/users/user2.jpg';

const Forms = () => {
    const [patientInfo, setPatientInfo] = useState({
        id: '',
        password: '',
        name: '',
        age: '',
        gender: '',
        phoneNumber: '',
        ssn: '',
        mobile: '',
        address: ''
    });

    const fileInputRef = useRef(null);

    const [file, setFile] = useState(null);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setPatientInfo({
            ...patientInfo,
            [name]: value
        });
    };

    const handleImageClick = () => {
        fileInputRef.current.click();
    };

    const handleFileChange = (e) => {
        const selectedFile = e.target.files[0];
        setFile(selectedFile);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('환자 정보가 제출되었습니다:', patientInfo);
        console.log('사진 파일:', file);
    };

    return (
        <div>
            <Card>
                <CardBody>
                    <CardTitle tag="h5">환자 관리</CardTitle>
                    <Row>
                        {/* md 크기 이상일 때 왼쪽 칸 */}
                        <Col md="4">
                            {/* 업로드된 환자 사진을 표시하는 부분 (이미지 클릭 시 파일 선택 창이 나타남) */}
                            <div style={{ cursor: 'pointer' }} onClick={handleImageClick}>
                                <h5>환자 사진 업로드</h5>
                                <img
                                    src={file ? URL.createObjectURL(file) : defaultImage}
                                    alt="환자 사진"
                                    style={{ maxWidth: '200px', height: 'auto', border: '1px solid #ccc' }}
                                />
                            </div>
                            <input
                                type="file"
                                ref={fileInputRef}
                                style={{ display: 'none' }}
                                onChange={handleFileChange}
                                accept="image/*"
                            />
                        </Col>
                        {/* md 크기 이상일 때 오른쪽 칸 */}
                        <Col md="6" xs="12">
                            <Form onSubmit={handleSubmit}>
                                <FormGroup row>
                                    <Label for="name" sm={2}>이름</Label>
                                    <Col sm={10}>
                                        <Input
                                            type="text"
                                            name="name"
                                            id="name"
                                            value={patientInfo.name}
                                            onChange={handleChange}
                                            required
                                        />
                                    </Col>
                                </FormGroup>

                                <FormGroup row>
                                    <Label for="age" sm={2}>나이</Label>
                                    <Col sm={10}>
                                        <Input
                                            type="text"
                                            name="age"
                                            id="age"
                                            value={patientInfo.age}
                                            onChange={handleChange}
                                            required
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Label for="gender" sm={2}>성별</Label>
                                    <Col sm={10}>
                                        <Input
                                            type="select"
                                            name="gender"
                                            id="gender"
                                            value={patientInfo.gender}
                                            onChange={handleChange}
                                            required
                                        >
                                            <option value="">성별 선택</option>
                                            <option value="male">남성</option>
                                            <option value="female">여성</option>
                                        </Input>
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Label for="phoneNumber" sm={3}>전화번호</Label>
                                    <Col sm={10}>
                                        <Input
                                            type="tel"
                                            name="phoneNumber"
                                            id="phoneNumber"
                                            value={patientInfo.phoneNumber}
                                            onChange={handleChange}
                                            required
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup row>
                                    <Label for="ssn">주민번호</Label>
                                    <Col sm={10}>
                                        <Input
                                            type="text"
                                            name="ssn"
                                            id="ssn"
                                            value={patientInfo.ssn}
                                            onChange={handleChange}
                                            required
                                        />
                                    </Col>
                                </FormGroup>
                                <FormGroup>
                                    <Col sm={10}>
                                    <Label for="mobile">휴대전화</Label>
                                        <Input
                                            type="tel"
                                            name="mobile"
                                            id="mobile"
                                            value={patientInfo.mobile}
                                            onChange={handleChange}
                                            required
                                        />
                                    </Col>

                                </FormGroup>
                                <FormGroup row>

                                    <Label for="address">주소</Label>
                                    <Col sm={10}>
                                        <Input
                                            type="text"
                                            name="address"
                                            id="address"
                                            value={patientInfo.address}
                                            onChange={handleChange}
                                            required
                                        />
                                    </Col>
                                </FormGroup>
                                <Button color="primary" type="submit">등록</Button>
                            </Form>
                        </Col>

                    </Row>
                </CardBody>
            </Card>
        </div>
    );
};

export default Forms;