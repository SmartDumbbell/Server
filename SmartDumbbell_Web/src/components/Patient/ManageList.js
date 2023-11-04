import React, { useState, useEffect } from 'react';
import { Card, CardBody, CardTitle, Nav, NavItem, NavLink, TabContent, TabPane, ListGroup, ListGroupItem, Pagination, PaginationItem, PaginationLink } from 'reactstrap';

const Manager = () => {
    const [activeTab, setActiveTab] = useState('assignedPatients');
    const [assignedPatients, setAssignedPatients] = useState([]);
    const [allPatients, setAllPatients] = useState([]);
    const [assignedPatientsPage, setAssignedPatientsPage] = useState(1);
    const [allPatientsPage, setAllPatientsPage] = useState(1);
    const patientsPerPage = 5; // 페이지당 보여줄 환자 수

    useEffect(() => {
        // API 엔드포인트 - 담당 환자 리스트
        const apiUrlAssignedPatients = 'http://localhost:8080/WebProcess/myUsers';

        // API 호출 - 담당 환자 리스트
        fetch(apiUrlAssignedPatients, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ trainer: '김트레이너' }),
        })
            .then(response => response.json())
            .then(data => {
                // API 응답에서 이름 추출하여 assignedPatients 상태에 추가
                const names = data.map(user => user.name);
                setAssignedPatients(names);
            })
            .catch(error => {
                console.error('Error fetching assigned patients data:', error);
            });

        // API 엔드포인트 - 전체 환자 리스트
        const apiUrlAllPatients = 'http://localhost:8080/WebProcess/UserAll';

        // API 호출 - 전체 환자 리스트
        fetch(apiUrlAllPatients)
            .then(response => response.json())
            .then(data => {
                // API 응답에서 전체 환자 리스트를 받아와서 allPatients 상태에 추가
                setAllPatients(data);
            })
            .catch(error => {
                console.error('Error fetching all patients data:', error);
            });
    }, []); // 빈 배열을 두번째 매개변수로 넘겨주면 컴포넌트가 마운트될 때 한 번만 실행됩니다.

    const toggleTab = (tab) => {
        if (activeTab !== tab) setActiveTab(tab);
    };

    const paginate = (tab, pageNumber) => {
        if (tab === 'assignedPatients') {
            setAssignedPatientsPage(pageNumber);
        } else if (tab === 'allPatients') {
            setAllPatientsPage(pageNumber);
        }
    };

    const renderPatients = (patients, page) => {
        const indexOfLastPatient = page * patientsPerPage;
        const indexOfFirstPatient = indexOfLastPatient - patientsPerPage;
        const currentPatients = patients.slice(indexOfFirstPatient, indexOfLastPatient);

        return (
            <div>
                <ListGroup>
                    {currentPatients.map((name, index) => (
                        <ListGroupItem key={index}>{name}</ListGroupItem>
                    ))}
                </ListGroup>
                <Pagination className="mt-3">
                    {Array.from({ length: Math.ceil(patients.length / patientsPerPage) }, (_, index) => (
                        <PaginationItem key={index} className={page === index + 1 ? 'active' : ''}>
                            <PaginationLink onClick={() => paginate(activeTab, index + 1)}>
                                {index + 1}
                            </PaginationLink>
                        </PaginationItem>
                    ))}
                </Pagination>
            </div>
        );
    };

    return (
        <div className="container mt-4">
            <Card>
                <CardBody>
                    <CardTitle style={{ fontSize: '24px', fontWeight: 'bold', marginBottom: '20px' }}>환자 관리</CardTitle>
                    <Nav tabs>
                        <NavItem>
                            <NavLink
                                className={activeTab === 'assignedPatients' ? 'active' : ''}
                                onClick={() => { toggleTab('assignedPatients'); }}
                            >
                                담당 환자 리스트
                            </NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink
                                className={activeTab === 'allPatients' ? 'active' : ''}
                                onClick={() => { toggleTab('allPatients'); }}
                            >
                                전체 유저 리스트
                            </NavLink>
                        </NavItem>
                    </Nav>
                    <TabContent activeTab={activeTab}>
                        <TabPane tabId="assignedPatients">
                            {renderPatients(assignedPatients, assignedPatientsPage)}
                        </TabPane>
                        <TabPane tabId="allPatients">
                            {renderPatients(allPatients, allPatientsPage)}
                        </TabPane>
                    </TabContent>
                </CardBody>
            </Card>
        </div>
    );
};

export default Manager;
