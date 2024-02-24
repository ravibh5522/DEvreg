def bisection(f,a,b,N):
    if f(a)*f(b) >= 0:
        print("Bisection fails.")
        return None
    a_n = a
    b_n = b
    for n in range(1,N+1):
        m_n = (a_n + b_n)/2
        f_m_n = f(m_n)
        if f(a_n)*f_m_n < 0:
            a_n = a_n
            b_n = m_n
        elif f(b_n)*f_m_n < 0:
            a_n = m_n
            b_n = b_n
        else:
            return m_n
    return (a_n + b_n)/2
def secant(f,x0,x1,N):
    for i in range(0,N):
        x2 = x1 - f(x1)*(x1 - x0)/(f(x1) - f(x0))
        x0 = x1
        x1 = x2
    return x2
def newton_raphson(f,df,x0,N):
    for i in range(0,N):
        x0 = x0 - f(x0)/df(x0)
    return x0

f = lambda x: x**3 - x - 1
df = lambda x: 3*x**2 - 1
a=1 
b=2
x0 = 1
x1 = 2
N = 7

approx_phi = bisection(f,a,b,N)
approx_phi2 = secant(f,x0,x1,N)
approx_phi1 = newton_raphson(f,df,x0,N)

print(approx_phi)
print(approx_phi1)
print(approx_phi2)
