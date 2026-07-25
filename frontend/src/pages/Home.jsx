import AuditForm from "../components/AuditForm";
import Footer from "../components/Footer";
import Header from "../components/Header";

function Home() {
  return (
    <main className="min-h-screen">
      <div className="fixed inset-0 -z-10 overflow-hidden">
        <div
          className="
        absolute
        -top-40
        -left-32
        w-[650px]
        h-[650px]
        rounded-full
        bg-blue-200
        blur-3xl
        opacity-40
        "
        />

        <div
          className="
        absolute
        top-20
        -right-32
        w-[550px]
        h-[550px]
        rounded-full
        bg-sky-200
        blur-3xl
        opacity-30
        "
        />

        <div
          className="
        absolute
        bottom-[-250px]
        left-1/2
        -translate-x-1/2
        w-[900px]
        h-[900px]
        rounded-full
        bg-blue-100
        blur-3xl
        opacity-30
        "
        />
      </div>
      <div className="max-w-4xl mx-auto px-6">
        <Header />
        <AuditForm />
        <Footer />
      </div>
    </main>

  );
}

export default Home;
