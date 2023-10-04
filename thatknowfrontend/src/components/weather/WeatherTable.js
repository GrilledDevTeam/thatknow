import React from 'react';
import './UserStyles.css';

export default function WeatherTable({ data }) {
    console.log(data);
    const addfcstDate = (item, index) => <th key={index}>{item.fcstDate}</th>;
    const addfcstTime = (item, index) => <th key={index}>{item.fcstTime}</th>;
    const addTMP = (item, index) => <th key={index}>{item.tmp}</th>;
    const addTMN = (item, index) => <th key={index}>{item.tmn}</th>;
    const addTMX = (item, index) => <th key={index}>{item.tmx}</th>;
    const addREH = (item, index) => <th key={index}>{item.reh}</th>;
    const addSKY = (item, index) => <th key={index}>{item.sky}</th>;
    const addPOP = (item, index) => <th key={index}>{item.pop}</th>;
    const addPTY = (item, index) => <th key={index}>{item.pty}</th>;
    const addPCP = (item, index) => <th key={index}>{item.pcp}</th>;
    const addSNO = (item, index) => <th key={index}>{item.sno}</th>;
    const addWSD = (item, index) => <th key={index}>{item.wsd}</th>;

    
    return (
        <div className="weatherTable">
            <table>
                <thead>
                <tr>
                    <th>예보날짜</th>
                    {data.map((item, index) => addfcstDate(item, index))}
                </tr>
                <tr>
                    <th>예보시간</th>
                    {data.map((item, index) => addfcstTime(item, index))}
                </tr>
                <tr>
                    <th>TMP</th>
                    {data.map((item, index) => addTMP(item, index))}
                </tr>
                <tr>
                    <th>TMN</th>
                    {data.map((item, index) => addTMN(item, index))}
                </tr>
                <tr>
                    <th>TMX</th>
                    {data.map((item, index) => addTMX(item, index))}
                </tr>
                <tr>
                    <th>REH</th>
                    {data.map((item, index) => addREH(item, index))}
                </tr>
                <tr>
                    <th>SKY</th>
                    {data.map((item, index) => addSKY(item, index))}
                </tr>
                <tr>
                    <th>POP</th>
                    {data.map((item, index) => addPOP(item, index))}
                </tr>
                <tr>
                    <th>PTY</th>
                    {data.map((item, index) => addPTY(item, index))}
                </tr>
                <tr>
                    <th>PCP</th>
                    {data.map((item, index) => addPCP(item, index))}
                </tr>
                <tr>
                    <th>SNO</th>
                    {data.map((item, index) => addSNO(item, index))}
                </tr>
                <tr>
                    <th>WSD</th>
                    {data.map((item, index) => addWSD(item, index))}
                </tr>
                </thead>
            </table>
        </div>
    );
}