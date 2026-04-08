import { useEffect, useState } from "react";
import "./App.css";

function Card({ title, value, unit }) {
  return (
    <div className="card">
      <div className="card-glow" />
      <div className="card-title">{title}</div>
      <div className="card-value">
        {value}
        {unit && <span className="card-unit"> {unit}</span>}
      </div>
    </div>
  );
}

function App() {
  const [data, setData] = useState(null);
  const [time, setTime] = useState(new Date());

  useEffect(() => {
    const fetchData = () => {
      fetch("http://localhost:8080/api/ventilation/status")
        .then((res) => {
          if (!res.ok) {
            throw new Error(`HTTP ${res.status}`);
          }
          return res.json();
        })
        .then(setData)
        .catch((err) => console.error("Fetch error:", err));
    };

    fetchData();
    const poll = setInterval(fetchData, 2000);
    const clock = setInterval(() => setTime(new Date()), 1000);

    return () => {
      clearInterval(poll);
      clearInterval(clock);
    };
  }, []);

  if (!data) {
    return (
      <div className="matrix-page">
        <div className="scanlines" />
        <div className="loading">INITIALIZING VENTILATION LINK...</div>
      </div>
    );
  }

  return (
    <div className="matrix-page">
      <div className="scanlines" />

      <header className="topbar">
        <div>
          <div className="eyebrow">ÖSTBERG HERU / LOCAL NODE</div>
          <h1>VENTILATION BJØRNDALEN</h1>
        </div>
        <div className="status-box">
          <div className="status-dot" />
          <span>SYSTEM ONLINE</span>
        </div>
      </header>

      <section className="hero-panel">
        <div className="hero-left">
          <div className="section-label">LIVE STATUS</div>
          <div className="mode">{data.mode}</div>
          <div className="subtext">
            LAST UPDATE: {time.toLocaleTimeString()}
          </div>
        </div>

        <div className="hero-right">
          <div className="mini-stat">
            <span className="mini-label">NODE</span>
            <span className="mini-value">HERU-01</span>
          </div>
          <div className="mini-stat">
            <span className="mini-label">LINK</span>
            <span className="mini-value">MODBUS READY</span>
          </div>
        </div>
      </section>

      <section className="grid">
        <Card title="TILLUFT" value={data.supplyTemp} unit="°C" />
        <Card title="AVTREKK" value={data.extractTemp} unit="°C" />
        <Card title="VIFTE" value={data.fanSpeed} unit="%" />
        <Card title="MODUS" value={data.mode} />
      </section>

      <section className="terminal-panel">
        <div className="section-label">SYSTEM LOG</div>
        <div className="terminal-line">&gt; backend connected</div>
        <div className="terminal-line">&gt; api endpoint responding</div>
        <div className="terminal-line">
          &gt; supply_temp = {data.supplyTemp}°C
        </div>
        <div className="terminal-line">
          &gt; extract_temp = {data.extractTemp}°C
        </div>
        <div className="terminal-line">&gt; fan_speed = {data.fanSpeed}%</div>
        <div className="terminal-line">&gt; mode = {data.mode}</div>
      </section>
    </div>
  );
}

export default App;