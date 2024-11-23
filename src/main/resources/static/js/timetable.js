//const Sunday =[
//    {
//        time: 'Sunday',
//        roomNumber: 'Holiday',
//        subject: 'No class Available',
//        type: ''
//    }
//]
//const Monday =[
//    {
//        time: '09-10 AM',
//        roomNumber: '38-718',
//        subject: 'DBMS130',
//        type: 'Lecture'
//    },
//    {
//        time: '10-11 AM',
//        roomNumber: '38-718',
//        subject: 'MTH166',
//        type: 'Tutorial'
//    },
//    {
//        time: '12-01 PM',
//        roomNumber: '38-718',
//        subject: 'NS200',
//        type: 'Lecture'
//    }
//]
//const Tuesday =[
//    {
//        time: '09-10 AM',
//        roomNumber: '27-304Y',
//        subject: 'MTH166',
//        type: 'Tutorial'
//    },
//    {
//        time: '11-12 AM',
//        roomNumber: '28-107',
//        subject: 'CS849',
//        type: 'Lecture'
//    },
//    {
//        time: '12-01 PM',
//        roomNumber: '28-107',
//        subject: 'CS849',
//        type: 'Lecture'
//    },
//    {
//        time: '02-03 PM',
//        roomNumber: '38-718',
//        subject: 'NS200',
//        type: 'Lecture'
//    }
//]
//
//const Wednesday =[
//    {
//        time: '10-11 AM',
//        roomNumber: '33-309',
//        subject: 'DBMS130',
//        type: 'Lecture'
//    },
//    {
//        time: '11-12 AM',
//        roomNumber: '38-719',
//        subject: 'CS200',
//        type: 'Lecture'
//    }
//]
//
//const Thursday =[
//    {
//        time: '11-12 AM',
//        roomNumber: '33-309',
//        subject: 'MTH166',
//        type: 'Lecture'
//    },
//    {
//        time: '01-02 PM',
//        roomNumber: '38-719',
//        subject: 'CS849',
//        type: 'Lecture'
//    },
//    {
//        time: '02-03 PM',
//        roomNumber: '38-718',
//        subject: 'NS200',
//        type: 'Lecture'
//    }
//]
//
//const Friday =[
//    {
//        time: '10-11 AM',
//        roomNumber: '33-309',
//        subject: 'MEC103',
//        type: 'Lecture'
//    },
//    {
//        time: '11-12 AM',
//        roomNumber: '33-309',
//        subject: 'MEC103',
//        type: 'Lecture'
//    },
//    {
//        time: '02-03 PM',
//        roomNumber: '33-601',
//        subject: 'CS849',
//        type: 'Tutorial'
//    },
//
//]
//
//const Saturday =[
//    {
//        time: '09-10 AM',
//        roomNumber: '34-604',
//        subject: 'DBMS130',
//        type: 'Tutorial'
//    },
//    {
//        time: '10-11 AM',
//        roomNumber: '34-604',
//        subject: 'DBMS130',
//        type: 'Lecture'
//    },
//    {
//        time: '01-02 PM',
//        roomNumber: '33-309',
//        subject: 'MTH166',
//        type: 'Lecture'
//    }
//]

const API_URL = "http://localhost:8085/timetables";
const days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
let currentDayIndex = new Date().getDay();

const fetchTimetable = async (day) => {
    try {
        const response = await fetch(`/timetables/day/${day}`);
        const data = await response.json();
        renderTimetable(data);
    } catch (error) {
        console.error("Error fetching timetable:", error);
    }
};

const renderTimetable = (data) => {
    const tbody = document.getElementById("timetableBody");
    tbody.innerHTML = "";
    if (data.length === 0) {
        tbody.innerHTML = `<tr><td colspan="4">No classes available.</td></tr>`;
        return;
    }
    data.forEach((entry) => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${entry.time}</td>
            <td>${entry.roomNumber}</td>
            <td>${entry.subject}</td>
            <td>${entry.type}</td>
        `;
        tbody.appendChild(tr);
    });
};

const updateDay = () => {
    document.getElementById("currentDay").innerText = days[currentDayIndex];
    fetchTimetable(days[currentDayIndex]);
};

document.getElementById("nextDay").addEventListener("click", () => {
    currentDayIndex = (currentDayIndex + 1) % 7;
    updateDay();
});

document.getElementById("prevDay").addEventListener("click", () => {
    currentDayIndex = (currentDayIndex - 1 + 7) % 7;
    updateDay();
});

updateDay();
